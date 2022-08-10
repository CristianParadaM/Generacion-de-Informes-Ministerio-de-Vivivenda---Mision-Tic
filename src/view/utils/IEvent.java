package view.utils;

import java.util.EventListener;

/**
 * @author CRISTIAN DAVID PARADA MARTINEZ
 * @date 8/08/2022
 */
public interface IEvent extends EventListener{
	/**
	 * Evento que captura algun commando
	 * @param command comando 
	 */
	public void iEvent(String command);
}
