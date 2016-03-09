package com.wingoflights.pilotstation.api.lib.drone.mission.item.spatial;

import android.os.Parcel;

import com.wingoflights.pilotstation.api.lib.coordinate.LatLongAlt;
import com.wingoflights.pilotstation.api.lib.drone.mission.MissionItemType;
import com.wingoflights.pilotstation.api.lib.drone.mission.item.MissionItem;

/**
 * Points the nose of the vehicle and camera gimbal at the “region of interest”.
 * Created by fhuya on 11/6/14.
 */
public class RegionOfInterest extends BaseSpatialItem implements android.os.Parcelable {

    public RegionOfInterest(){
        super(MissionItemType.REGION_OF_INTEREST);
    }

    public RegionOfInterest(RegionOfInterest copy) {
        super(copy);
    }

    private RegionOfInterest(Parcel in) {
        super(in);
    }

    @Override
    public MissionItem clone() {
        return new RegionOfInterest(this);
    }

    public static final Creator<RegionOfInterest> CREATOR = new Creator<RegionOfInterest>() {
        public RegionOfInterest createFromParcel(Parcel source) {
            return new RegionOfInterest(source);
        }

        public RegionOfInterest[] newArray(int size) {
            return new RegionOfInterest[size];
        }
    };
}
