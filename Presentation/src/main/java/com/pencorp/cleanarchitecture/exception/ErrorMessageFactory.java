package com.pencorp.cleanarchitecture.exception;

import android.content.Context;

import com.pencorp.cleanarchitecture.R;
import com.pencorp.data.exception.NetworkConnectionException;

/**
 * Created by Tuane on 5/03/17.
 */

public class ErrorMessageFactory {


    private ErrorMessageFactory() {
        //empty
    }

    /**
     * Creates a String representing an error message.
     *
     * @param context Context needed to retrieve string resources.
     * @param exception An exception used as a condition to retrieve the correct error message.
     * @return {@link String} an error message.
     */
    public static String create(Context context, Exception exception) {
        String message = context.getString(R.string.exception_message_generic);

        if (exception instanceof NetworkConnectionException) {
            message = context.getString(R.string.exception_message_no_connection);
        } else if (exception instanceof InfoNotFoundException) {
            message = context.getString(R.string.exception_message_info_not_found);
        }

        return message;
    }
}
