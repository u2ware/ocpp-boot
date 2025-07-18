
package io.u2ware.ocpp.v1_6.model;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonValue;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;
import lombok.experimental.SuperBuilder;

@JsonInclude(JsonInclude.Include.ALWAYS)
@SuperBuilder
@ToString
@Getter
@Accessors(fluent = true)
@NoArgsConstructor
@AllArgsConstructor
@JsonPropertyOrder({
    "value",
    "context",
    "format",
    "measurand",
    "phase",
    "location",
    "unit"
})
@Generated("jsonschema2pojo")
public class SampledValue {

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("value")
    @NotNull
    private String value;
    @JsonProperty("context")
    private SampledValue.Context context;
    @JsonProperty("format")
    private SampledValue.Format format;
    @JsonProperty("measurand")
    private SampledValue.Measurand measurand;
    @JsonProperty("phase")
    private SampledValue.Phase phase;
    @JsonProperty("location")
    private SampledValue.Location location;
    @JsonProperty("unit")
    private SampledValue.Unit unit;

    @Generated("jsonschema2pojo")
    public enum Context {

        INTERRUPTION_BEGIN("Interruption.Begin"),
        INTERRUPTION_END("Interruption.End"),
        SAMPLE_CLOCK("Sample.Clock"),
        SAMPLE_PERIODIC("Sample.Periodic"),
        TRANSACTION_BEGIN("Transaction.Begin"),
        TRANSACTION_END("Transaction.End"),
        TRIGGER("Trigger"),
        OTHER("Other");
        private final String value;
        private final static Map<String, SampledValue.Context> CONSTANTS = new HashMap<String, SampledValue.Context>();

        static {
            for (SampledValue.Context c: values()) {
                CONSTANTS.put(c.value, c);
            }
        }

        Context(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return this.value;
        }

        @JsonValue
        public String value() {
            return this.value;
        }

        @JsonCreator
        public static SampledValue.Context fromValue(String value) {
            SampledValue.Context constant = CONSTANTS.get(value);
            if (constant == null) {
                throw new IllegalArgumentException(value);
            } else {
                return constant;
            }
        }

    }

    @Generated("jsonschema2pojo")
    public enum Format {

        RAW("Raw"),
        SIGNED_DATA("SignedData");
        private final String value;
        private final static Map<String, SampledValue.Format> CONSTANTS = new HashMap<String, SampledValue.Format>();

        static {
            for (SampledValue.Format c: values()) {
                CONSTANTS.put(c.value, c);
            }
        }

        Format(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return this.value;
        }

        @JsonValue
        public String value() {
            return this.value;
        }

        @JsonCreator
        public static SampledValue.Format fromValue(String value) {
            SampledValue.Format constant = CONSTANTS.get(value);
            if (constant == null) {
                throw new IllegalArgumentException(value);
            } else {
                return constant;
            }
        }

    }

    @Generated("jsonschema2pojo")
    public enum Location {

        CABLE("Cable"),
        EV("EV"),
        INLET("Inlet"),
        OUTLET("Outlet"),
        BODY("Body");
        private final String value;
        private final static Map<String, SampledValue.Location> CONSTANTS = new HashMap<String, SampledValue.Location>();

        static {
            for (SampledValue.Location c: values()) {
                CONSTANTS.put(c.value, c);
            }
        }

        Location(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return this.value;
        }

        @JsonValue
        public String value() {
            return this.value;
        }

        @JsonCreator
        public static SampledValue.Location fromValue(String value) {
            SampledValue.Location constant = CONSTANTS.get(value);
            if (constant == null) {
                throw new IllegalArgumentException(value);
            } else {
                return constant;
            }
        }

    }

    @Generated("jsonschema2pojo")
    public enum Measurand {

        ENERGY_ACTIVE_EXPORT_REGISTER("Energy.Active.Export.Register"),
        ENERGY_ACTIVE_IMPORT_REGISTER("Energy.Active.Import.Register"),
        ENERGY_REACTIVE_EXPORT_REGISTER("Energy.Reactive.Export.Register"),
        ENERGY_REACTIVE_IMPORT_REGISTER("Energy.Reactive.Import.Register"),
        ENERGY_ACTIVE_EXPORT_INTERVAL("Energy.Active.Export.Interval"),
        ENERGY_ACTIVE_IMPORT_INTERVAL("Energy.Active.Import.Interval"),
        ENERGY_REACTIVE_EXPORT_INTERVAL("Energy.Reactive.Export.Interval"),
        ENERGY_REACTIVE_IMPORT_INTERVAL("Energy.Reactive.Import.Interval"),
        POWER_ACTIVE_EXPORT("Power.Active.Export"),
        POWER_ACTIVE_IMPORT("Power.Active.Import"),
        POWER_OFFERED("Power.Offered"),
        POWER_REACTIVE_EXPORT("Power.Reactive.Export"),
        POWER_REACTIVE_IMPORT("Power.Reactive.Import"),
        POWER_FACTOR("Power.Factor"),
        CURRENT_IMPORT("Current.Import"),
        CURRENT_EXPORT("Current.Export"),
        CURRENT_OFFERED("Current.Offered"),
        VOLTAGE("Voltage"),
        FREQUENCY("Frequency"),
        TEMPERATURE("Temperature"),
        SO_C("SoC"),
        RPM("RPM");
        private final String value;
        private final static Map<String, SampledValue.Measurand> CONSTANTS = new HashMap<String, SampledValue.Measurand>();

        static {
            for (SampledValue.Measurand c: values()) {
                CONSTANTS.put(c.value, c);
            }
        }

        Measurand(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return this.value;
        }

        @JsonValue
        public String value() {
            return this.value;
        }

        @JsonCreator
        public static SampledValue.Measurand fromValue(String value) {
            SampledValue.Measurand constant = CONSTANTS.get(value);
            if (constant == null) {
                throw new IllegalArgumentException(value);
            } else {
                return constant;
            }
        }

    }

    @Generated("jsonschema2pojo")
    public enum Phase {

        L_1("L1"),
        L_2("L2"),
        L_3("L3"),
        N("N"),
        L_1_N("L1-N"),
        L_2_N("L2-N"),
        L_3_N("L3-N"),
        L_1_L_2("L1-L2"),
        L_2_L_3("L2-L3"),
        L_3_L_1("L3-L1");
        private final String value;
        private final static Map<String, SampledValue.Phase> CONSTANTS = new HashMap<String, SampledValue.Phase>();

        static {
            for (SampledValue.Phase c: values()) {
                CONSTANTS.put(c.value, c);
            }
        }

        Phase(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return this.value;
        }

        @JsonValue
        public String value() {
            return this.value;
        }

        @JsonCreator
        public static SampledValue.Phase fromValue(String value) {
            SampledValue.Phase constant = CONSTANTS.get(value);
            if (constant == null) {
                throw new IllegalArgumentException(value);
            } else {
                return constant;
            }
        }

    }

    @Generated("jsonschema2pojo")
    public enum Unit {

        WH("Wh"),
        K_WH("kWh"),
        VARH("varh"),
        KVARH("kvarh"),
        W("W"),
        K_W("kW"),
        VA("VA"),
        K_VA("kVA"),
        VAR("var"),
        KVAR("kvar"),
        A("A"),
        V("V"),
        K("K"),
        CELCIUS("Celcius"),
        CELSIUS("Celsius"),
        FAHRENHEIT("Fahrenheit"),
        PERCENT("Percent");
        private final String value;
        private final static Map<String, SampledValue.Unit> CONSTANTS = new HashMap<String, SampledValue.Unit>();

        static {
            for (SampledValue.Unit c: values()) {
                CONSTANTS.put(c.value, c);
            }
        }

        Unit(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return this.value;
        }

        @JsonValue
        public String value() {
            return this.value;
        }

        @JsonCreator
        public static SampledValue.Unit fromValue(String value) {
            SampledValue.Unit constant = CONSTANTS.get(value);
            if (constant == null) {
                throw new IllegalArgumentException(value);
            } else {
                return constant;
            }
        }

    }

}
