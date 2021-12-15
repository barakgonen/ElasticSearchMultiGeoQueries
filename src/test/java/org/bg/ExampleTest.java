package org.bg;

import org.elasticsearch.action.admin.indices.create.CreateIndexRequest;
import org.elasticsearch.xcontent.XContentBuilder;
import org.elasticsearch.xcontent.XContentFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

public class ExampleTest {

    @Before
    public void setUp() {
    }

    @After
    public void clear() {

    }

    /**
     * TestCase for exact Method and endPoint matching
     */
    @Test
    public void testIndex() {
        CreateIndexRequest request = new CreateIndexRequest("twitter");

    }

    @Test
    public void writeToIndex() {
        CreateIndexRequest request = new CreateIndexRequest("twitter");
        XContentBuilder builder = null;
        try {
            builder = XContentFactory.jsonBuilder();
            builder.startObject();
            {
                builder.startObject("properties");
                {
                    builder.startObject("message");
                    {
                        builder.field("type", "text");
                    }
                    builder.endObject();
                }
                builder.endObject();
            }
            builder.endObject();
            request.mapping(String.valueOf(builder));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}