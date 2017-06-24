package com.mikemunhall.hbasedaotest.dao;

import com.mikemunhall.hbasedaotest.model.FlightInfo;
import org.apache.hadoop.hbase.HColumnDescriptor;
import org.apache.hadoop.hbase.HTableDescriptor;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.*;
import org.apache.hadoop.hbase.util.Bytes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.hadoop.hbase.HbaseTemplate;
import org.springframework.data.hadoop.hbase.RowMapper;
import org.springframework.data.hadoop.hbase.TableCallback;
import org.springframework.stereotype.Repository;
import javax.annotation.PostConstruct;
import java.io.IOException;
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

    public void save(FlightInfo sd) {
        hbaseTemplate.execute(tableNameStr, new TableCallback<Object>() {
            public Object doInTable(HTableInterface table) throws Throwable {
                Put p = new Put(Bytes.toBytes(sd.getID()));
                p.addColumn(cf, Bytes.toBytes("ID"), Bytes.toBytes(sd.getID()));
                table.put(p);

                return null;
            }
        });
    }

    public List<FlightInfo> findAll() {
        Scan scan = new Scan();
        scan.setMaxResultSize(100l); // TODO: Investigate. This setting is ignored on my local standalone installation.

        return hbaseTemplate.find(tableNameStr, scan, new SessionDataRowMapper());
    }

    public FlightInfo findOne(String rowName) {
        FlightInfo flightInfo = hbaseTemplate.get(tableNameStr, rowName, columnFamily, new SessionDataRowMapper());

        if (flightInfo.getID() == null) {
            flightInfo = null;
        }

        return flightInfo;
    }

    private class SessionDataRowMapper implements RowMapper<FlightInfo> {
        @Override
        public FlightInfo mapRow(Result result, int rowNum) throws Exception {
            FlightInfo flightInfo = new FlightInfo();
            flightInfo.setABSTAT(Bytes.toString(result.getValue(cf, Bytes.toBytes("ABSTAT"))));
            flightInfo.setID(Bytes.toString(result.getValue(cf, Bytes.toBytes("ID"))));
            flightInfo.setPFID(Bytes.toString(result.getValue(cf, Bytes.toBytes("PFID"))));
            flightInfo.setSCHID(Bytes.toString(result.getValue(cf, Bytes.toBytes("SCHID"))));
            flightInfo.setFLNO(Bytes.toString(result.getValue(cf, Bytes.toBytes("FLNO"))));

            return flightInfo;
        }
    }

}
