package model_v2;

import model_v2.tags.AddressTags;
import model_v2.tags.ModelType;

public class Contact extends StandardItem<String, Contact.Data> {

    public static class Data {

        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

    }

    public Contact(String hash, Data data) {
        super(hash, AddressTags.CONTACT, data);
    }


    public Contact(BoxModel boxModel) {
        super(boxModel);
    }

    public Contact(DatabaseModel<String> databaseModel) {
        super(databaseModel);
    }

    @Override
    void visit(ModelVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public Data createEmptyData() {
        return null;
    }

}
