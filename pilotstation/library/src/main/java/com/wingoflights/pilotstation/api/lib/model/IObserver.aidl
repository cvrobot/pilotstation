// IObserver.aidl
package com.wingoflights.pilotstation.api.lib.model;

/**
* Asynchronous notification on change of vehicle state is available by registering observers for
* attribute changes.
*/
interface IObserver {

    /**
    * Notify observer that the named attribute has changed.
    * @param attributeEvent event describing the update. The supported events are listed in {@link com.wingoflights.pilotstation.api.lib.drone.attribute.AttributeEvent}
    * @param attributeBundle bundle object from which additional event data can be retrieved.
    */
    void onAttributeUpdated(String attributeEvent, in Bundle eventExtras);

}
