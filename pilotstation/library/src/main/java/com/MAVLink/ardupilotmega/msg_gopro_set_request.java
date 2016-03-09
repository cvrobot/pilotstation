/* AUTO-GENERATED FILE.  DO NOT MODIFY.
 *
 * This class was automatically generated by the
 * java mavlink generator tool. It should not be modified by hand.
 */

// MESSAGE GOPRO_SET_REQUEST PACKING
package com.MAVLink.ardupilotmega;
import com.MAVLink.MAVLinkPacket;
import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.MAVLinkPayload;
        
/**
* Request to set a GOPRO_COMMAND with a desired
*/
public class msg_gopro_set_request extends MAVLinkMessage{

    public static final int MAVLINK_MSG_ID_GOPRO_SET_REQUEST = 218;
    public static final int MAVLINK_MSG_LENGTH = 7;
    private static final long serialVersionUID = MAVLINK_MSG_ID_GOPRO_SET_REQUEST;


      
    /**
    * System ID
    */
    public short target_system;
      
    /**
    * Component ID
    */
    public short target_component;
      
    /**
    * Command ID
    */
    public short cmd_id;
      
    /**
    * Value
    */
    public short value[] = new short[4];
    

    /**
    * Generates the payload for a mavlink message for a message of this type
    * @return
    */
    public MAVLinkPacket pack(){
        MAVLinkPacket packet = new MAVLinkPacket();
        packet.len = MAVLINK_MSG_LENGTH;
        packet.sysid = 255;
        packet.compid = 190;
        packet.msgid = MAVLINK_MSG_ID_GOPRO_SET_REQUEST;
              
        packet.payload.putUnsignedByte(target_system);
              
        packet.payload.putUnsignedByte(target_component);
              
        packet.payload.putUnsignedByte(cmd_id);
              
        
        for (int i = 0; i < value.length; i++) {
            packet.payload.putUnsignedByte(value[i]);
        }
                    
        
        return packet;
    }

    /**
    * Decode a gopro_set_request message into this class fields
    *
    * @param payload The message to decode
    */
    public void unpack(MAVLinkPayload payload) {
        payload.resetIndex();
              
        this.target_system = payload.getUnsignedByte();
              
        this.target_component = payload.getUnsignedByte();
              
        this.cmd_id = payload.getUnsignedByte();
              
         
        for (int i = 0; i < this.value.length; i++) {
            this.value[i] = payload.getUnsignedByte();
        }
                
        
    }

    /**
    * Constructor for a new message, just initializes the msgid
    */
    public msg_gopro_set_request(){
        msgid = MAVLINK_MSG_ID_GOPRO_SET_REQUEST;
    }

    /**
    * Constructor for a new message, initializes the message with the payload
    * from a mavlink packet
    *
    */
    public msg_gopro_set_request(MAVLinkPacket mavLinkPacket){
        this.sysid = mavLinkPacket.sysid;
        this.compid = mavLinkPacket.compid;
        this.msgid = MAVLINK_MSG_ID_GOPRO_SET_REQUEST;
        unpack(mavLinkPacket.payload);        
    }

            
    /**
    * Returns a string with the MSG name and data
    */
    public String toString(){
        return "MAVLINK_MSG_ID_GOPRO_SET_REQUEST -"+" target_system:"+target_system+" target_component:"+target_component+" cmd_id:"+cmd_id+" value:"+value+"";
    }
}
        