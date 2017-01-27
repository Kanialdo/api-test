package model_v2;

public interface DatabaseModel<ID> {

    long getDatabaseId();

    ID getDatabaseHash();

    String getDatabaseType();

    String getDatabaseJson();

    String getDatabaseTags();

    boolean getDatabaseSyncStatus();

}
