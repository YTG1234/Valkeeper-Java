package com.ytg123.valkeeper_portable;

import java.util.ArrayList;
import java.util.List;

/**
 * @author YTG123
 * @version 1.2.0
 * @since 1.0.0
 */
public class ValueKeeper {
    /**
     * <p>
     *     A List that stores all of the com.ytg123.valkeeper.ValueKepper.Value s.
     * </p>
     */
    private List<Value> values = new ArrayList<Value>();

    /**
     * Set a value or create a new one.
     * <p>
     *     Searches for a com.ytg123.valkeeper.ValueKepper.Value with the identifier specified,
     *     if it finds one it will replace the old value with the new T value.
     * </p>
     * @param identifier The com.ytg123.valkeeper.ValueKepper.Value's identifier.
     * @param value The value of the com.ytg123.valkeeper.ValueKepper.Value's value.
     * @param <T> The type of the value.
     */
    public <T> void set(String identifier, T value) {
        boolean found = false;
        for (Value<T> val : values) {
            if (val.getIdentifier().equals(identifier) && !found) {
                found = true;
                val.setValue(value);
            }
        } if (!found) {
            values.add(new Value<T>(identifier, value));
        }
    }

    /**
     * Get a value.
     * <p>
     *     Searches the value list for a value with the specified identifier. <br>
     *     If it finds one, returns the value. <br>
     *     If not, returns null.
     * </p>
     * @param identifier The com.ytg123.valkeeper.ValueKepper.Value's identifier.
     * @param <T> The type of the value.
     * @return The value of the com.ytg123.valkeeper.ValueKepper.Value. if there isn't any, null.
     */
    public <T> T get(String identifier) {
        boolean found = false;
        for (Value<T> val : values) {
            if (val.getIdentifier().equals(identifier) && !found) {
                found = true;
                return val.getValue();
            }
        }
        return null;
    }

    /**
     * A class to store the value information.
     * @param <T> The type of the value.
     */
    private static class Value<T> {
        /**
         * The identifier, use to identify this Value object. <br>
         * Once set, cannot change it.
         */
        private String identifier;
        /**
         * The value, which is the information stored in the Value object.
         */
        private T value;

        /**
         *
         * @param identifier The value's identifier.
         * @param value The information stored in the Value object.
         */
        public Value(String identifier, T value) {
            this.identifier = identifier;
            this.value = value;
        }

        /**
         * Just another getter method...
         * @return The identifier of the Value object.
         */
        public String getIdentifier() { return this.identifier; }

        /**
         * Just another getter method...
         * @return The Value's value.
         */
        public T getValue() { return this.value; }

        // public void setIdentifier(String newIdentifier) { this.identifier = newIdentifier; }

        /**
         * Just another setter method... <br>
         * Sets the value to a new one.
         * @param newValue The new value.
         */
        public void setValue(T newValue) { this.value = newValue; }
    }
}

