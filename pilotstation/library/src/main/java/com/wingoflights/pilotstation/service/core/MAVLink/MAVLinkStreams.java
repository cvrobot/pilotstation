package com.wingoflights.pilotstation.service.core.MAVLink;

import com.MAVLink.MAVLinkPacket;
import com.MAVLink.Messages.MAVLinkMessage;
import com.wingoflights.pilotstation.api.lib.model.ICommandListener;

public class MAVLinkStreams {

	public interface MAVLinkOutputStream {

		void sendMavMessage(MAVLinkMessage message, int sysId, int compId, ICommandListener listener);

		void sendMavMessage(MAVLinkMessage message, ICommandListener listener);

		boolean isConnected();

		void toggleConnectionState();

        void openConnection();

        void closeConnection();

	}

	public interface MavlinkInputStream {
        public void notifyStartingConnection();

		public void notifyConnected();

		public void notifyDisconnected();

		public void notifyReceivedData(MAVLinkPacket packet);

        public void onStreamError(String errorMsg);
	}
}
