package broadcast.impl;

import broadcast.FilterableBroadcastObserver;
import utils.SupportedId;

public interface ContactObserver extends FilterableBroadcastObserver {

    void itemUpdated();

    SupportedId<String> getContactSupportedId();

}
