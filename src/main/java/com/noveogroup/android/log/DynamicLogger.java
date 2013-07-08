/*
 * Copyright (c) 2013 Noveo Group
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * Except as contained in this notice, the name(s) of the above copyright holders
 * shall not be used in advertising or otherwise to promote the sale, use or
 * other dealings in this Software without prior written authorization.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL
 * THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package com.noveogroup.android.log;

import android.util.Log;

/**
 * Dynamic implementation of {@link Logger}. In reality this logger never does
 * work, it simply defines how to create a {@link SimpleLogger}
 *
 * <b>Attention</b>: Android may set its own requirement for logging level
 * using {@link Log#isLoggable(String, int)} method. This logger doesn't take
 * it into account in {@link #isEnabled(Level)}.
 */
public class DynamicLogger extends SimpleLogger {

    private final TagSpecifier tagSpecifier;

    public static enum TagSpecifier {

        SIMPLE_NAME("*"),
        CANONICAL_NAME("**");

        private final String tagSpecifier;

        private TagSpecifier(String tagSpecifier) {
            this.tagSpecifier = tagSpecifier;
        }

        public static TagSpecifier fromString(String string) {
            for (TagSpecifier tagSpecifier : TagSpecifier.values()) {
                if (tagSpecifier.toString().equals(string)) {
                    return tagSpecifier;
                }
            }

            throw new IllegalArgumentException("'" + string + "' is not a valid TagSpecifier.");
        }

        @Override
        public String toString() {
            return tagSpecifier;
        }
    }

    /**
     * Creates new {@link DynamicLogger} instance.
     *
     * @param tagSpecifier  definition of tag to create
     * @param level the logging level or {@code null} if no messages should be printed.
     */
    public DynamicLogger(TagSpecifier tagSpecifier, Level level) {
        super(null, level);
        this.tagSpecifier = tagSpecifier;
    }

    /**
     * Returns the tagSpecifier.
     *
     * @return the tagSpecifier.
     */
    public TagSpecifier getTagSpecifier() {
        return tagSpecifier;
    }
}
