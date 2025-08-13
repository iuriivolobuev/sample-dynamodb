package app;

import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbPartitionKey;

import java.util.UUID;

import static io.qala.datagen.RandomShortApi.alphanumeric;

@DynamoDbBean
public class Dog {
    private String id;
    private String name;

    @DynamoDbPartitionKey
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static Dog random() {
        Dog dog = new Dog();
        dog.id = UUID.randomUUID().toString();
        dog.name = alphanumeric(1, 100);
        return dog;
    }
}
