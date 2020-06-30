package io.confluent.schemaregistry.benchmark;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.avro.Schema;
import org.apache.avro.SchemaBuilder;
import org.apache.avro.specific.SpecificRecord;
import org.apache.avro.specific.SpecificRecordBase;
import org.apache.avro.util.Utf8;

import java.util.Collections;

public class myrecord extends SpecificRecordBase implements SpecificRecord {
    //private static Schema $SCHEMA = (Schema) SchemaRegistryPerformance.makeParsedSchema("AVRO", 1)..rawSchema();
    private static Schema $SCHEMA = SchemaBuilder.record("myrecord")
            .namespace("io.confluent.schemaregistry.benchmark")
            .fields()
            .requiredString("f1")
            .endRecord();

    public myrecord(Utf8 f1) {
        this.f1 = f1;
    }

    private Utf8 f1;

    public myrecord() {
    }

    @Override
    public Schema getSchema() {
        return $SCHEMA;
    }

    @Override
    public Object get(int field) {
        return f1;
    }

    @Override
    public void put(int field, Object value) {
        f1 = (Utf8) value;
    }

    public Utf8 getF1() {
        return f1;
    }

    public void setF1(Utf8 f1) {
        this.f1 = f1;
    }
}
