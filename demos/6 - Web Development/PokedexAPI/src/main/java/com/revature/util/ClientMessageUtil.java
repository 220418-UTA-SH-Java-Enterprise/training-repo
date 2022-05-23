package com.revature.util;

import com.revature.model.ClientMessage;

public class ClientMessageUtil {
	public static final ClientMessage CREATION_SUCCESSFUL = new ClientMessage("CREATION OF POKEMON WAS SUCCESSFUL");
	public static final ClientMessage CREATION_FAILED = new ClientMessage("SOMETHING WENT WRONG DURING POKEMON CREATION");
	public static final ClientMessage REGISTRATION_SUCCESSFUL = new ClientMessage("TRAINER REGISTATION SUCCESSFUL");
	public static final ClientMessage REGISTRATION_FAILED = new ClientMessage("SOMETHING WENT WRONG DURING REGISTRATION");
	public static final ClientMessage UPDATE_SUCCESSFUL = new ClientMessage("UPDATE SUCCESSFUL");
	public static final ClientMessage UPDATE_FAILED = new ClientMessage("SOMETHING WENT WRONG DURING UPDATE");
	public static final ClientMessage DELETION_SUCCESSFUL = new ClientMessage("DELETION SUCCESSFUL");
	public static final ClientMessage DELETION_FAILED = new ClientMessage("SOMETHING WENT WRONG DURING DELETION");
}
