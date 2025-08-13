package app;

import software.amazon.awssdk.auth.credentials.ProfileCredentialsProvider;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbTable;
import software.amazon.awssdk.enhanced.dynamodb.TableSchema;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;

import java.net.URI;

class DynamoDb {
    private static final String PROFILE_LOCAL = "local";
    private static final DynamoDbClient CLIENT = DynamoDbClient.builder().region(Region.EU_CENTRAL_1)
            .credentialsProvider(ProfileCredentialsProvider.create(PROFILE_LOCAL))
            .endpointOverride(URI.create("http://localhost:8000")).build();
    private static final DynamoDbEnhancedClient ENHANCED_CLIENT = DynamoDbEnhancedClient.builder().dynamoDbClient(CLIENT).build();
    private static final DynamoDbTable<Dog> DOG_TABLE = ENHANCED_CLIENT.table("dog", TableSchema.fromBean(Dog.class));

    public static DynamoDbTable<Dog> dogTable() {
        return DOG_TABLE;
    }
}
