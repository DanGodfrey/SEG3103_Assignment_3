
package CounterUI;

public class BarCodeReaderEvent {
  String code;
  BarCodeReaderEvent(String code){
    this.code = code;
  }
  String getCode() { return code; }
}