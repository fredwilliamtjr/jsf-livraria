/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.caelum.livraria.util;

import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

/**
 *
 * @author fredw
 */
 
// Mostra os estados da fase do JSP
public class LogPhaseListener implements PhaseListener{

    @Override
    public void afterPhase(PhaseEvent pe) {
        
    }

    @Override
    public void beforePhase(PhaseEvent event) {
        System.out.println("FASE :  " + event.getPhaseId());
    }

    @Override
    public PhaseId getPhaseId() {
        return PhaseId.ANY_PHASE;
    }
    
}
