package model_v2.tags;

import model_v2.BoxModel;
import model_v2.DatabaseModel;
import model_v2.StandardItem;

/**
 * Created by kryst on 28.01.2017.
 */
public interface AdvancedType {

    String getTag();

    StandardItem createFromBox(BoxModel model);

    StandardItem createFromDatabase(DatabaseModel model);

    static AdvancedType resolveAdvanceType(String tag) {

        if (AddressTags.has(tag)) {
            return AddressTags.find(tag);
        }

        return null;

    }

}
