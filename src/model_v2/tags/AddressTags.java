package model_v2.tags;


import actions.Reaction1;
import model_v2.BoxModel;
import model_v2.Contact;
import model_v2.DatabaseModel;
import model_v2.StandardItem;

public enum AddressTags implements AdvancedType {

    CONTACT("CONTACT", Contact::new, Contact::new);

    private final String tag;
    private final Reaction1<StandardItem, BoxModel> fromBoxFactory;
    private final Reaction1<StandardItem, DatabaseModel> fromModelFactory;

    AddressTags(String tag, Reaction1<StandardItem, BoxModel> fromBoxFactory, Reaction1<StandardItem, DatabaseModel> fromModelFactory) {
        this.tag = tag;
        this.fromBoxFactory = fromBoxFactory;
        this.fromModelFactory = fromModelFactory;
    }

    @Override
    public StandardItem createFromBox(BoxModel model) {
        return fromBoxFactory.run(model);
    }

    @Override
    public StandardItem createFromDatabase(DatabaseModel model) {
        return fromModelFactory.run(model);
    }

    @Override
    public String getTag() {
        return toString();
    }

    public static boolean has(String tag) {

        for (AddressTags c : AddressTags.values()) {
            if (c.tag.equals(tag)) {
                return true;
            }
        }

        return false;

    }

    public static AddressTags find(String tag) {

        for (AddressTags c : AddressTags.values()) {
            if (c.tag.equals(tag)) {
                return c;
            }
        }

        return null;

    }

}
