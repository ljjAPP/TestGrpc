import java.util.HashMap;
import java.util.Map;

public class PlcBridge {
    private PLC plc;

    private Map<String, Integer> map = new HashMap<>();

    public void setRange(String range){

    }

    private PlcBridge(String hostAddress, int port) {
        this.plc = MitsubishiFX5U.getPlc(hostAddress, port);
    }

    private PlcBridge(String hostAddress, int port, int slaveId) {
        this.plc = MitsubishiFX5U.getPlc(hostAddress, port, slaveId);
    }

    private PlcBridge(String hostAddress, int port, int slaveId, boolean isKeepingAlive, boolean openAutoIncrementTransactionId) {
        this.plc = MitsubishiFX5U.getPlc(hostAddress, port, slaveId, isKeepingAlive, openAutoIncrementTransactionId);
    }

    private static class PlcBridgeHolder {
        private PlcBridge plc;

        private PlcBridgeHolder(String hostAddress, int port, int slaveId, boolean isKeepingAlive, boolean openAutoIncrementTransactionId) {
            this.plc = new PlcBridge(hostAddress, port, slaveId, isKeepingAlive, openAutoIncrementTransactionId);
        }

        private PlcBridgeHolder(String hostAddress, int port, int slaveId) {
            this.plc = new PlcBridge(hostAddress, port, slaveId);
        }

        private PlcBridgeHolder(String hostAddress, int port) {
            this.plc = new PlcBridge(hostAddress, port);
        }
    }

    public static PlcBridge getPlc(String hostAddress, int port, int slaveId, boolean isKeepingAlive, boolean openAutoIncrementTransactionId) {
        return new PlcBridge.PlcBridgeHolder(hostAddress, port, slaveId, isKeepingAlive, openAutoIncrementTransactionId).plc;
    }

    public static PlcBridge getPlc(String hostAddress, int port, int slaveId) {
        return new PlcBridge.PlcBridgeHolder(hostAddress, port, slaveId).plc;
    }

    public static PlcBridge getPlc(String hostAddress, int port) {
        return new PlcBridge.PlcBridgeHolder(hostAddress, port).plc;
    }

}
