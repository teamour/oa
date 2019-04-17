package com.our.oa.utils;

import java.time.LocalDateTime;

import com.p6spy.engine.spy.appender.MessageFormattingStrategy;

/*
 * 
 */
public class P6SpyCustomForamt implements MessageFormattingStrategy {

	@Override
	public String formatMessage(int connectionId, String now, long elapsed, String category, String prepared, String sql, String arg6) {
        return !"".equals(sql.trim()) ? "[ " + LocalDateTime.now() + " ] --- | took "
                + elapsed + "ms | " + category + " | connection " + connectionId + "\n "
                + sql + ";" : "";
	}

}
