package utils;

import java.util.*;

/**
 * Created by kryst on 27.01.2017.
 */
public class SupportedId<Type> {

    enum Mode {
        NONE,
        ONE,
        MANY
    }

    private Mode mode;
    private Type id;
    private List<Type> ids;

    public SupportedId() {
        mode = Mode.NONE;
    }

    public SupportedId(Type... ids) {

        if (ids != null) {
            if (ids.length == 0) {
                mode = Mode.NONE;
            } else if (ids.length == 1) {
                mode = Mode.ONE;
                id = ids[0];
            } else {
                mode = Mode.MANY;
                this.ids = Arrays.asList(ids);
            }
        } else {
            mode = Mode.NONE;
        }

    }

    public SupportedId(List<Type> list) {
        this.ids = ids;
    }

    public static <Type> boolean check(Type lookingFor, SupportedId<Type> supportedIds) {

        if (supportedIds != null) {
            switch (supportedIds.mode) {
                case NONE:
                    return false;
                case ONE:
                    return lookingFor.equals(supportedIds.id);
                case MANY:
                    return supportedIds.ids.contains(lookingFor);
                default:
                    return false;
            }
        } else {
            return false;
        }

    }

}
