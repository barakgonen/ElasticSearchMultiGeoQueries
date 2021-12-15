package org.bg.elastic.test;

import org.elasticsearch.common.bytes.BytesReference;
import org.joda.time.DateTime;

public class ChangeEvent {
    private final String index;
    private final String id;
    private final String type;
    private final DateTime timestamp;
    private final Operation operation;
    private final long version;
    private final BytesReference source;

    public enum Operation {
        INDEX,CREATE,DELETE
    }

    public ChangeEvent(String index, String type, String id, DateTime timestamp, Operation operation, long version, BytesReference source) {

        this.index = index;
        this.id = id;
        this.type = type;
        this.timestamp = timestamp;
        this.operation = operation;
        this.version = version;
        this.source = source;
    }

    public String getIndex() {
        return index;
    }

    public String getId() {
        return id;
    }

    public Operation getOperation() {
        return operation;
    }

    public DateTime getTimestamp() {
        return timestamp;
    }

    public String getType() {
        return type;
    }

    public long getVersion() {
        return version;
    }

    public BytesReference getSource() {
        return source;
    }
}
