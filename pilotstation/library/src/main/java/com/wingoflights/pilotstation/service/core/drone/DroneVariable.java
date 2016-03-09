package com.wingoflights.pilotstation.service.core.drone;

import android.os.Handler;
import android.os.RemoteException;

import com.wingoflights.pilotstation.api.lib.model.ICommandListener;

import com.wingoflights.pilotstation.service.core.drone.autopilot.MavLinkDrone;

import timber.log.Timber;

public class DroneVariable<T extends MavLinkDrone> {
	protected T myDrone;

	public DroneVariable(T myDrone) {
		this.myDrone = myDrone;
	}

	/**
	 * Convenience method to post a success event to the listener.
	 * @param handler Use to dispatch the event
	 * @param listener To whom the event is dispatched.
	 */
	protected void postSuccessEvent(Handler handler, final ICommandListener listener){
		if(handler != null && listener != null){
			handler.post(new Runnable() {
				@Override
				public void run() {
					try {
						listener.onSuccess();
					} catch (RemoteException e) {
						Timber.e(e, e.getMessage());
					}
				}
			});
		}
	}

	/**
	 * Convenience method to post an error event to the listener.
	 * @param handler Use to dispatch the event
	 * @param listener To whom the event is dispatched.
	 *                 @param error Execution error.
	 */
	protected void postErrorEvent(Handler handler, final ICommandListener listener, final int error){
		if(handler != null && listener != null){
			handler.post(new Runnable() {
				@Override
				public void run() {
					try {
						listener.onError(error);
					} catch (RemoteException e) {
						Timber.e(e, e.getMessage());
					}
				}
			});
		}
	}

	/**
	 * Convenience method to post a timeout event to the listener.
	 * @param handler Use to dispatch the event
	 * @param listener To whom the event is dispatched.
	 */
	protected void postTimeoutEvent(Handler handler, final ICommandListener listener){
		if(handler != null && listener != null){
			handler.post(new Runnable() {
				@Override
				public void run() {
					try {
						listener.onTimeout();
					} catch (RemoteException e) {
						Timber.e(e, e.getMessage());
					}
				}
			});
		}
	}
}