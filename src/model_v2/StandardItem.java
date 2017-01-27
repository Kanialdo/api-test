package model_v2;

import model_v2.tags.AdvancedType;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by kryst on 27.01.2017.
 */
public abstract class StandardItem<ID, Data> extends Item implements BoxModel, DatabaseModel<ID> {

    long id;
    ID hash;
    Data data;
    AdvancedType type;
    Set<String> flags;
    boolean syncStatus;

    public StandardItem(ID hash, AdvancedType type, Data data) {

        this.id = 0;
        this.hash = hash;
        this.data = data;
        this.type = type;
        this.flags = new HashSet<>();
        this.syncStatus = false;

    }

    public StandardItem(BoxModel boxModel) {

        this.id = 0;
        this.hash = createHash(boxModel.getBoxHash());
        this.data = createData(boxModel.getBoxJson());
        this.type = resolveType(boxModel.getBoxTags());
        this.flags = resolveFlags(boxModel.getBoxTags());
        this.syncStatus = true;

    }

    public StandardItem(DatabaseModel<ID> databaseModel) {

        this.id = databaseModel.getDatabaseId();
        this.hash = databaseModel.getDatabaseHash();
        this.data = createData(databaseModel.getDatabaseJson());
        this.type = resolveType(convertTags(databaseModel.getDatabaseTags()));
        this.flags = resolveFlags(convertTags(databaseModel.getDatabaseTags()));
        this.syncStatus = databaseModel.getDatabaseSyncStatus();

    }

    // ----- ABSTRACT --------------------------------------------------------------------------------------------------

    protected abstract ID createHash(String boxHash);

    protected abstract Data createData();

    protected abstract Data createData(String json);

    // ----- UTILS -----------------------------------------------------------------------------------------------------

    protected Set<String> resolveFlags(Set<String> boxTags) {
        return null;
    }

    protected AdvancedType resolveType(Set<String> boxTags) {
        return null;
    }

    protected AdvancedType resolveType(String type) {
        return AdvancedType.resolveAdvanceType(type);
    }

    protected abstract Object getGsonBuilderComponents();

    public String toJson() {
        return getGsonBuilderComponents().toString();
    }

    private Set<String> convertTags(String string) {
        return null;
    }

    private String convertTags(Set<String> tags) {
        return null;
    }

    private Set<String> packTags() {
        HashSet<String> set = new HashSet<>(flags);
        set.add(type.toString());
        return set;
    }

    // ----- DB --------------------------------------------------------------------------------------------------------

    @Override
    public long getDatabaseId() {
        return id;
    }

    @Override
    public ID getDatabaseHash() {
        return hash;
    }

    @Override
    public String getDatabaseType() {
        return type.toString();
    }

    @Override
    public String getDatabaseJson() {
        return toJson();
    }

    @Override
    public String getDatabaseTags() {
        return convertTags(packTags());
    }

    @Override
    public boolean getDatabaseSyncStatus() {
        return syncStatus;
    }

    // ----- BOX -------------------------------------------------------------------------------------------------------

    @Override
    public String getBoxHash() {
        return hash.toString();
    }

    @Override
    public String getBoxJson() {
        return toJson();
    }

    @Override
    public Set<String> getBoxTags() {
        return packTags();
    }

}

