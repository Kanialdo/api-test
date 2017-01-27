package model_v2.tags;

        import actions.Reaction1;
        import model_v2.BoxModel;
        import model_v2.Contact;
        import model_v2.DatabaseModel;
        import model_v2.StandardItem;

/**
 * Created by kryst on 27.01.2017.
 */
public enum ModelType {

    CONTACT("CONTACT", Contact::new, Contact::new)

    ;


    private final String tag;
    private final Reaction1<StandardItem, BoxModel> fromBoxFactory;
    private final Reaction1<StandardItem, DatabaseModel> fromModelFactory;

    ModelType(String tag, Reaction1<StandardItem, BoxModel> fromBoxFactory, Reaction1<StandardItem, DatabaseModel> fromModelFactory) {
        this.tag = tag;
        this.fromBoxFactory = fromBoxFactory;
        this.fromModelFactory = fromModelFactory;
    }

}
