/*
 * Copyright (c) 2009-2011 jMonkeyEngine
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are
 * met:
 * 
 * * Redistributions of source code must retain the above copyright
 *   notice, this list of conditions and the following disclaimer.
 *
 * * Redistributions in binary form must reproduce the above copyright
 *   notice, this list of conditions and the following disclaimer in the
 *   documentation and/or other materials provided with the distribution.
 *
 * * Neither the name of 'jMonkeyEngine' nor the names of its contributors
 *   may be used to endorse or promote products derived from this software
 *   without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED
 * TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR
 * PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
 * PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 * LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package my.game.network.messages;

//import network.messagages.PhysicsSyncMessage;
import com.jme3.math.Vector3f;
import com.jme3.network.serializing.Serializable;
import com.jme3.scene.Spatial;
import my.game.controls.NetworkEnableControl;
//import controls.NetworkedManualControl;

/**
 * Manual (human) control message, used bidirectional
 * @author normenhansen
 */
@Serializable()
public class NetworkTranslationMessage extends PhysicsSyncMessage {

	private long id;
	public Vector3f translation;

    public NetworkTranslationMessage() {
    }

	
    public NetworkTranslationMessage(NetworkTranslationMessage msg) {
//        setReliable(false);
        this.id = msg.id;
		this.translation = msg.translation;
    }


	public NetworkTranslationMessage(long id, Vector3f translation) {
//        setReliable(false);
        this.id = id;
        this.translation = translation;
    }
/*
    @Override
    public void applyData(Object object) {
        NetworkEnableControl control = ((Spatial) object).getControl(NetworkEnableControl.class);
        assert (control != null);
        control.doMoveX(moveX);
        control.doMoveY(moveY);
        control.doMoveZ(moveZ);
        control.doRotateX(aimX);
        control.doRotateY(aimY);
        control.doRotateZ(aimY);
    }
*/
    @Override
    public void applyData(Object object) {
        NetworkEnableControl control = ((Spatial) object).getControl(NetworkEnableControl.class);
        assert (control != null);
        control.doSetLocalTranslation(translation);
    }


}
