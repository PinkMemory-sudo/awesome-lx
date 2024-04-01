* 向量引擎



**不适合**

* 拿一行
* 事务
* 高并发



MergeTree 



```
docker run -d --name clickhouse-server --ulimit nofile=262144:262144 -p 8123:8123 -p 9000:9000 -p 9009:9009 -v /path/to/clickhouse/data:/var/lib/clickhouse d01e1f47cfab
```



primary keys in ClickHouse are not unique for each row in a table

索引列不能进行更新

分布式表不能进行更新

Cannot convert NULL value to non-Nullable type: while converting source column order_sub_id to destination column order_sub_id: while executing 'FUNCTION _CAST(order_sub_id :: 1, String :: 23) -> _CAST(order_sub_id, String) String : 22'. (CANNOT_INSERT_NULL_IN_ORDINARY_COLUMN) (version 22.3.5.5 (official build))