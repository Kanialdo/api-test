package broadcast;

import actions.Action0;
import actions.Action1;
import actions.Reaction1;

import javax.swing.*;
import java.util.*;

public class Broadcast {

    private static HashMap<Class<? extends BroadCastObserver>, Collection<? extends BroadCastObserver>> data = new HashMap<>();

    public static <Type extends BroadCastObserver> void post(Class<Type> type, Action1<Type> action) {
        post(type, action, null, null);
    }

    public static <Type extends BroadCastObserver> void post(Class<Type> type, Action1<Type> action, Action0 onAnyAction) {
        post(type, action, null, onAnyAction);
    }

    public static <Type extends BroadCastObserver> void post(Class<Type> type, Action1<Type> action, Reaction1<Boolean, Type> filter) {
        post(type, action, filter, null);
    }

    public static <Type extends BroadCastObserver> void post(Class<Type> type, Action1<Type> action, Reaction1<Boolean, Type> filter, Action0 onAnyAction) {

        List<Type> list = new ArrayList<>();

        if (list.size() > 0) {
            for (BroadCastObserver item : list) {
                if (filter.run((Type) item)) {
                    action.run((Type) item);
                }
            }
        } else if (onAnyAction != null) {
            onAnyAction.run();
        }

    }


}


