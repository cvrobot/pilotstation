// IMavlinkObserver.aidl
package com.wingoflights.pilotstation.api.lib.model;

import com.wingoflights.pilotstation.api.lib.mavlink.MavlinkMessageWrapper;

/**
* Asynchronous notification on receipt of new mavlink message.
*/
 interface IMavlinkObserver {

    /**
    * Notify observer that a mavlink message was received.
    * @param messageWrapper Wrapper for the received mavlink message.
    */
    void onMavlinkMessageReceived(in MavlinkMessageWrapper messageWrapper);
}
