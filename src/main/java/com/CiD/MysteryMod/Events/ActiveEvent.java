package com.CiD.MysteryMod.Events;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

import akka.actor.FSM.Event;
//USELESS ATM
@Target({ElementType.METHOD})
public @interface ActiveEvent {

	Class event() default BaseEvent.class;
	
	
}
