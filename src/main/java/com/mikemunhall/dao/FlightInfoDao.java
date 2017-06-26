package com.mikemunhall.dao;

import com.mikemunhall.model.FlightInfo;
import org.apache.hadoop.hbase.HColumnDescriptor;
import org.apache.hadoop.hbase.HTableDescriptor;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.*;
import org.apache.hadoop.hbase.filter.*;
import org.apache.hadoop.hbase.util.Bytes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.hadoop.hbase.HbaseTemplate;
import org.springframework.data.hadoop.hbase.RowMapper;
import org.springframework.data.hadoop.hbase.TableCallback;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.List;

@Repository
public class FlightInfoDao {

    @Autowired
    private HbaseTemplate hbaseTemplate;

    private String tableNameStr = "T_FLIGHT_INFO";
    private String columnFamily = "CF";
    private byte[] cf = Bytes.toBytes(columnFamily);

    private Admin admin;
    private TableName tn;

    public FlightInfoDao() { }

    @PostConstruct
    public void init() throws IOException {
        admin = ConnectionFactory.createConnection(hbaseTemplate.getConfiguration()).getAdmin();
        tn = TableName.valueOf(tableNameStr);

        if (!admin.tableExists(tn)) {
            HTableDescriptor tableDescriptor = new HTableDescriptor(tn);
            HColumnDescriptor columnDescriptor = new HColumnDescriptor(cf);
            columnDescriptor.setTimeToLive(432000); // five days
            tableDescriptor.addFamily(columnDescriptor);
            admin.createTable(tableDescriptor);

            //TODO: Log info message about creating table.
        }
    }

    public void drop() throws IOException {
        if (admin.isTableEnabled(tn)) {
            admin.disableTable(tn);
        }
        admin.deleteTable(tn);
    }

    public void save(final FlightInfo sd) {
        hbaseTemplate.execute(tableNameStr, new TableCallback<Object>() {
            public Object doInTable(HTableInterface table) throws Throwable {
                Put p = new Put(Bytes.toBytes(sd.getID()));
                p.addColumn(cf, Bytes.toBytes("ID"), Bytes.toBytes(sd.getID()));
                table.put(p);

                return null;
            }
        });
    }


    public FlightInfo get(String rowName) {
        FlightInfo flightInfo = hbaseTemplate.get(tableNameStr, rowName, columnFamily, new FlightInfoRowMapper());
        if (flightInfo.getID() == null) {
            flightInfo = null;
        }
        return flightInfo;
    }


    public List<FlightInfo> getPage(String key, int pageSize) {
        Scan scan = new Scan();
        scan.setStartRow(Bytes.toBytes(key));
        Filter filter = new PageFilter(pageSize);
        scan.setFilter(filter);
        // scan.setMaxResultSize(10); // TODO: Investigate. This setting is ignored on my local standalone installation.

        return hbaseTemplate.find(tableNameStr, scan, new FlightInfoRowMapper());
    }

    public List<FlightInfo> findByKeyPrefix(String key) {
        Scan scan = new Scan();
        scan.setRowPrefixFilter(Bytes.toBytes(key));
        scan.setMaxResultSize(100l);
        return hbaseTemplate.find(tableNameStr, scan, new FlightInfoRowMapper());
    }

    public List<FlightInfo> findByTime(String time) {
        Scan scan = new Scan();
        Filter filter = new RowFilter(CompareFilter.CompareOp.EQUAL, new SubstringComparator(time));
        scan.setFilter(filter);
        return hbaseTemplate.find(tableNameStr, scan, new FlightInfoRowMapper());
    }

    public List<FlightInfo> findByTimePeriod(String startTime, String endTime) {
        Scan scan = new Scan();
        Filter startFilter = new RowFilter(CompareFilter.CompareOp.GREATER_OR_EQUAL
                , new SubstringComparator(startTime));
        Filter endFilter = new RowFilter(CompareFilter.CompareOp.LESS_OR_EQUAL
                , new SubstringComparator(endTime));
        FilterList filterList = new FilterList(startFilter, endFilter);
        scan.setFilter(filterList);
        return hbaseTemplate.find(tableNameStr, scan, new FlightInfoRowMapper());
    }

    public List<FlightInfo> findByKeyPrefixAndTimePeriod(String key, String startTime, String endTime) {
        Scan scan = new Scan();
        scan.setStartRow(Bytes.toBytes(key));
        Filter startFilter = new RowFilter(CompareFilter.CompareOp.GREATER_OR_EQUAL
                , new SubstringComparator(startTime));
        Filter endFilter = new RowFilter(CompareFilter.CompareOp.LESS_OR_EQUAL
                , new SubstringComparator(endTime));
        FilterList filterList = new FilterList(startFilter, endFilter);
        scan.setFilter(filterList);
        return hbaseTemplate.find(tableNameStr, scan, new FlightInfoRowMapper());
    }

    public List<FlightInfo> findByADEPS(String ADEPS) {
        Scan scan = new Scan();
        SingleColumnValueFilter filter = new SingleColumnValueFilter(cf, Bytes.toBytes("ADEPS")
                , CompareFilter.CompareOp.EQUAL, Bytes.toBytes(ADEPS));
        scan.setFilter(filter);
        return hbaseTemplate.find(tableNameStr, scan, new FlightInfoRowMapper());
    }

    private class FlightInfoRowMapper implements RowMapper<FlightInfo> {
        @Override
        public FlightInfo mapRow(Result result, int rowNum) throws Exception {
            FlightInfo flightInfo = new FlightInfo();
            Field[] fields = flightInfo.getClass().getDeclaredFields();
            for (Field field : fields) {
                field.setAccessible(true);
                field.set(flightInfo, Bytes.toString(result.getValue(cf, Bytes.toBytes(field.getName()))));
            }

//            flightInfo.setABSTAT(Bytes.toString(result.getValue(cf, Bytes.toBytes("ABSTAT"))));
//            flightInfo.setID(Bytes.toString(result.getValue(cf, Bytes.toBytes("ID"))));
//            flightInfo.setPFID(Bytes.toString(result.getValue(cf, Bytes.toBytes("PFID"))));
//            flightInfo.setSCHID(Bytes.toString(result.getValue(cf, Bytes.toBytes("SCHID"))));
//            flightInfo.setFLNO(Bytes.toString(result.getValue(cf, Bytes.toBytes("FLNO"))));

            return flightInfo;
        }
    }

}
