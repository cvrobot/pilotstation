//ICommandListener.aidl
package com.wingoflights.pilotstation.api.lib.model;

/**
* Asynchronous notification of a command execution state.
*/
 interface ICommandListener {

    /**
    * Called when the command was executed successfully.
    */
    void onSuccess();

    /**
    * Called when the command execution failed.
    * @param executionError Defined by {@link com.wingoflights.pilotstation.api.lib.drone.attribute.error.CommandExecutionError}
    */
    void onError(int executionError);

    /**
    * Called when the command execution times out.
    */
    void onTimeout();

}