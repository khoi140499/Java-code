/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Client;

import Model.Message;
import java.io.IOException;

/**
 *
 */
public interface inReceiveMessage {
    
    public void ReceiveMessage(Message msg) throws IOException;
}
