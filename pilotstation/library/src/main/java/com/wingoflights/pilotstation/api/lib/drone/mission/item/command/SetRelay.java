package com.wingoflights.pilotstation.api.lib.drone.mission.item.command;

import android.os.Parcel;

import com.wingoflights.pilotstation.api.lib.drone.mission.MissionItemType;
import com.wingoflights.pilotstation.api.lib.drone.mission.item.MissionItem;

/**
 * Set a Relay pin’s voltage high or low.
 */
public class SetRelay extends MissionItem implements MissionItem.Command, android.os.Parcelable {

    private int relayNumber;
    private boolean enabled;

    public SetRelay() {
        super(MissionItemType.SET_RELAY);
    }

    public SetRelay(SetRelay copy) {
        this();
        this.relayNumber = copy.relayNumber;
        this.enabled = copy.enabled;
    }

    /**
     * @return relay number
     */
    public int getRelayNumber() {
        return relayNumber;
    }

    /**
     * Set the relay number
     *
     * @param relayNumber
     */
    public void setRelayNumber(int relayNumber) {
        this.relayNumber = relayNumber;
    }

    /**
     * @return true if relay is on, false if relay if off.
     */
    public boolean isEnabled() {
        return enabled;
    }

    /**
     * @param enabled true for relay to be on, false for relay to be off.
     */
    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    @Override
    public MissionItem clone() {
        return new SetRelay(this);
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        super.writeToParcel(dest, flags);
        dest.writeInt(this.relayNumber);
        dest.writeByte(enabled ? (byte) 1 : (byte) 0);
    }

    private SetRelay(Parcel in) {
        super(in);
        this.relayNumber = in.readInt();
        this.enabled = in.readByte() != 0;
    }

    public static final Creator<SetRelay> CREATOR = new Creator<SetRelay>() {
        public SetRelay createFromParcel(Parcel source) {
            return new SetRelay(source);
        }

        public SetRelay[] newArray(int size) {
            return new SetRelay[size];
        }
    };
}
