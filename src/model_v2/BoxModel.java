package model_v2;

import java.util.Set;

/**
 * Created by kryst on 27.01.2017.
 */
public interface BoxModel {

    String getBoxHash();

    String getBoxJson();

    Set<String> getBoxTags();

}
