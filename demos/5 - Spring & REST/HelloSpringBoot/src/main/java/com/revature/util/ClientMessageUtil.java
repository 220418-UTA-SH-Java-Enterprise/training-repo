package com.revature.util;

import com.revature.models.ClientMessage;

public class ClientMessageUtil {
	public static final ClientMessage CREATION_SUCCESSFUL = new ClientMessage("REGISTATION SUCCESSFUL");
	public static final ClientMessage CREATION_FAILED = new ClientMessage("SOMETHING WENT WRONG DURING CREATION");
	public static final ClientMessage UPDATE_SUCCESSFUL = new ClientMessage("UPDATE SUCCESSFUL");
	public static final ClientMessage UPDATE_FAILED = new ClientMessage("SOMETHING WENT WRONG DURING UPDATE");
	public static final ClientMessage DELETION_SUCCESSFUL = new ClientMessage("DELETION SUCCESSFUL");
	public static final ClientMessage DELETION_FAILED = new ClientMessage("SOMETHING WENT WRONG DURING DELETION");
}
