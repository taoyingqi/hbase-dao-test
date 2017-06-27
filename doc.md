# API document

|  |  |
|:----:|:----:|
| 功能描述 | rowkey 查询 |
| API接口  | /api/flightInfo/{key} |


|  |  |
|:----:|:----:|
| 功能描述 | rowkey 前缀查询 |
| API接口  | /api/flightInfo/prefix/{key} |


| | | | |
|:----:|:----:|:----:|:----:|
| 功能描述 | rowkey 时间点 | | |
| API接口  | /api/flightInfo/time | | |
| param | 参数名 | 必须 | 描述 |
|       | time   |  √  | 20170514,2017051414 |


|  |  | | |
|:----:|:----:|:----:|:----:|
| 功能描述 | rowkey 时间段 | | |
| API接口  | /api/flightInfo/period/time | | |
| param | 参数名 | 必须 | 描述 |
|       | startTime |  √  | 20170514 |
|       | endTime |  √  | 20170515 |

|  |  | | |
|:----:|:----:|:----:|:----:|
| 功能描述 | rowkey 前缀查询、时间段查询 | | |
| API接口  | /api/flightInfo/prefixAndTimePeriod | | |
| param | 参数名 | 必须 | 描述 |
|       | key |  √  |  |
|       | startTime |  √  | 20170514 |
|       | endTime |  √  | 20170515 |

|  |  | | |
|:----:|:----:|:----:|:----:|
| 功能描述 | ADEPS 起飞机场查询 | | |
| API接口  | /api/flightInfo/ADEPS | | |
| param | 参数名 | 必须 | 描述 |
|       | ADEPS |  √  |  |
