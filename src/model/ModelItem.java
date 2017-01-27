package model;

import actions.Reaction1;
import broadcast.Broadcast;
import broadcast.impl.ContactObserver;
import utils.SupportedId;

/**
 * Created by kryst on 27.01.2017.
 */
public class ModelItem {

    String id;

    public void onUpdate() {

        Broadcast.post(ContactObserver.class, ContactObserver::itemUpdated, contactObserver -> SupportedId.check(id, contactObserver.getContactSupportedId()));

    }


}
