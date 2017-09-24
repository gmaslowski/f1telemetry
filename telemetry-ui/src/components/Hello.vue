<template>
  <div class="hello">
    <h1>{{ msg }}</h1>
    <radial-gauge :value=telemetry.speed :options="{
      units: 'km/h',
      width: 350,
      height: 300,
      minValue: 0,
      maxValue:340,
      startAngle: 90,
      ticksAngle: 180,
      valueBox: true,
      majorTicks: ['0', '40', '80', '100', '140', '180', '200', '240', '280', '300', '340'],
      minorTicks: 2,
      strokeTicks: true,
      highlights: [{'from': 300, 'to': 340, 'color': 'rgba(200, 50, 50, .75)'}],
      colorPlate: '#fff',
      borderShadowWidth: 0,
      borders: false,
      needleType: 'arrow',
      needleWidth: 2,
      needleCircleSize: 7,
      needleCircleOuter: true,
      needleCircleInner: false,
      animation: false
    }"></radial-gauge>
    <radial-gauge :value=telemetry.gear :options="{
      title: 'Gear',
      width: 140,
      height: 140,
      minValue: 0,
      maxValue:9,
      startAngle: 0,
      ticksAngle: 180,
      valueBox: false,
      majorTicks: ['0', '1', '2', '3', '4', '5', '6', '7', '8', '9'],
      minorTicks: 2,
      strokeTicks: true,
      highlights: [{'from': 0, 'to': 10, 'color': 'white'}],
      fontNumbersSize: 25,
      colorPlate: '#fff',
      borderShadowWidth: 1,
      borders: false,
      needleType: 'arrow',
      needleWidth: 2,
      needleCircleSize: 7,
      needleCircleOuter: true,
      needleCircleInner: false,
      animation: true,
      animationRule: 'linear',
      animationDuration: 100
    }"></radial-gauge>
    <radial-gauge :value=telemetry.revs :options="{
      units: '1/min x 1000',
      width: 350,
      height: 300,
      minValue: 0,
      maxValue:13000,
      startAngle: 90,
      ticksAngle: 180,
      valueBox: true,
      majorTicks: ['0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '10', '11', '12', '13'],
      minorTicks: 2,
      strokeTicks: true,
      highlights: [{'from': 11000, 'to': 11499, 'color': '#41b883'}, {'from': 11500, 'to': 13000, 'color': 'rgba(200, 50, 50, .75)'}],
      colorPlate: '#fff',
      borderShadowWidth: 0,
      borders: false,
      needleType: 'arrow',
      needleWidth: 2,
      needleCircleSize: 7,
      needleCircleOuter: true,
      needleCircleInner: false,
      animation: false
    }"></radial-gauge>
    <br/>
    <div style="display: flex">
      <div style="flex: 3.5">
        <vm-progress :width="60" :percentage="telemetry.wheelWear.frontLeft" :type="'circle'"></vm-progress>
        <vm-progress :width="60" :percentage="telemetry.wheelWear.frontRight" :type="'circle'"></vm-progress>
        <br/>
        <vm-progress :width="60" :percentage="telemetry.wheelWear.rearLeft" :type="'circle'"></vm-progress>
        <vm-progress :width="60" :percentage="telemetry.wheelWear.rearRight" :type="'circle'"></vm-progress>
      </div>
      <div style="flex: 1">
        <radial-gauge :value=telemetry.fuelInTank :options="{
              width: 140,
              height: 140,
              units: '%',
              title: 'Fuel',
              minValue: 0, maxValue: 20,
              majorTicks: [0, 5, 10, 15, 20],
              minorTicks: 2,
              strokeTicks: true,
              highlights: [{'from': 0, 'to': 5, 'color': 'red'},
                           {'from': 5, 'to': 10, 'color': 'orange'}],
              valueBox: false,
              ticksAngle: 225,
              startAngle: 67.5,
              colorMajorTicks: '#ddd',
              colorMinorTicks: '#ddd',
              colorTitle: '#eee',
              colorUnits: '#ccc',
              colorNumbers: '#eee',
              colorPlate: '#333',
              borderShadowWidth: 0,
              borders: true,
              needleType: 'arrow',
              needleWidth: 2,
              needleCircleSize: 7,
              needleCircleOuter: true,
              needleCircleInner: false,
              colorBorderOuter: '#333',
              colorBorderOuterEnd: '#444',
              colorBorderMiddle: '#222',
              colorBorderMiddleEnd: '#444',
              colorBorderInner: '#444',
              colorBorderInnerEnd: '#333',
              colorNeedleShadowDown: '#333',
              colorNeedleCircleOuter: '#333',
              colorNeedleCircleOuterEnd: '#444',
              colorNeedleCircleInner: '#444',
              colorNeedleCircleInnerEnd: '#222',
              valueBoxBorderRadius: 0,
              colorValueBoxRect: '#222',
              colorValueBoxRectEnd: '#333',
              animation: false
        }"></radial-gauge>
      </div>
      <div style="flex: 3.5">
        <radial-gauge :value=telemetry.wheelTemperature.frontLeft :options="{
              width: 80, height: 80, units: 'C', title: 'Temp', minValue: 0, maxValue: 150,
              majorTicks: [30, 60, 90, 120, 150], minorTicks: 2, strokeTicks: true,
              highlights: [{'from': 0, 'to': 70, 'color': 'blue'},
                           {'from': 71, 'to': 110, 'color': 'green'},
                           {'from': 111, 'to': 150, 'color': 'red'}],
              valueBox: false, ticksAngle: 225, startAngle: 67.5,
              colorMajorTicks: '#ddd', colorMinorTicks: '#ddd', colorTitle: '#eee', colorUnits: '#ccc', colorNumbers: '#eee',
              colorPlate: '#333', borderShadowWidth: 0, borders: true, needleType: 'arrow', needleWidth: 2, needleCircleSize: 7,
              needleCircleOuter: true, needleCircleInner: false, colorBorderOuter: '#333', colorBorderOuterEnd: '#444',
              colorBorderMiddle: '#222', colorBorderMiddleEnd: '#444', colorBorderInner: '#444', colorBorderInnerEnd: '#333',
              colorNeedleShadowDown: '#333', colorNeedleCircleOuter: '#333', colorNeedleCircleOuterEnd: '#444',
              colorNeedleCircleInner: '#444', colorNeedleCircleInnerEnd: '#222', valueBoxBorderRadius: 0,
              colorValueBoxRect: '#222', colorValueBoxRectEnd: '#333', animation: false
        }"></radial-gauge>
        <radial-gauge :value=telemetry.wheelTemperature.frontRight :options="{
              width: 80, height: 80, units: 'C', title: 'Temp', minValue: 0, maxValue: 150,
              majorTicks: [30, 60, 90, 120, 150], minorTicks: 2, strokeTicks: true,
              highlights: [{'from': 0, 'to': 70, 'color': 'blue'},
                           {'from': 71, 'to': 110, 'color': 'green'},
                           {'from': 111, 'to': 150, 'color': 'red'}],
              valueBox: false, ticksAngle: 225, startAngle: 67.5,
              colorMajorTicks: '#ddd', colorMinorTicks: '#ddd', colorTitle: '#eee', colorUnits: '#ccc', colorNumbers: '#eee',
              colorPlate: '#333', borderShadowWidth: 0, borders: true, needleType: 'arrow', needleWidth: 2, needleCircleSize: 7,
              needleCircleOuter: true, needleCircleInner: false, colorBorderOuter: '#333', colorBorderOuterEnd: '#444',
              colorBorderMiddle: '#222', colorBorderMiddleEnd: '#444', colorBorderInner: '#444', colorBorderInnerEnd: '#333',
              colorNeedleShadowDown: '#333', colorNeedleCircleOuter: '#333', colorNeedleCircleOuterEnd: '#444',
              colorNeedleCircleInner: '#444', colorNeedleCircleInnerEnd: '#222', valueBoxBorderRadius: 0,
              colorValueBoxRect: '#222', colorValueBoxRectEnd: '#333', animation: false
        }"></radial-gauge>
        <br/>
        <radial-gauge :value=telemetry.wheelTemperature.rearLeft :options="{
              width: 80, height: 80, units: 'C', title: 'Temp', minValue: 0, maxValue: 150,
              majorTicks: [30, 60, 90, 120, 150], minorTicks: 2, strokeTicks: true,
              highlights: [{'from': 0, 'to': 70, 'color': 'blue'},
                           {'from': 71, 'to': 110, 'color': 'green'},
                           {'from': 111, 'to': 150, 'color': 'red'}],
              valueBox: false, ticksAngle: 225, startAngle: 67.5,
              colorMajorTicks: '#ddd', colorMinorTicks: '#ddd', colorTitle: '#eee', colorUnits: '#ccc', colorNumbers: '#eee',
              colorPlate: '#333', borderShadowWidth: 0, borders: true, needleType: 'arrow', needleWidth: 2, needleCircleSize: 7,
              needleCircleOuter: true, needleCircleInner: false, colorBorderOuter: '#333', colorBorderOuterEnd: '#444',
              colorBorderMiddle: '#222', colorBorderMiddleEnd: '#444', colorBorderInner: '#444', colorBorderInnerEnd: '#333',
              colorNeedleShadowDown: '#333', colorNeedleCircleOuter: '#333', colorNeedleCircleOuterEnd: '#444',
              colorNeedleCircleInner: '#444', colorNeedleCircleInnerEnd: '#222', valueBoxBorderRadius: 0,
              colorValueBoxRect: '#222', colorValueBoxRectEnd: '#333', animation: false
        }"></radial-gauge>
        <radial-gauge :value=telemetry.wheelTemperature.rearRight :options="{
              width: 80, height: 80, units: 'C', title: 'Temp', minValue: 0, maxValue: 150,
              majorTicks: [30, 60, 90, 120, 150], minorTicks: 2, strokeTicks: true,
              highlights: [{'from': 0, 'to': 70, 'color': 'blue'},
                           {'from': 71, 'to': 110, 'color': 'green'},
                           {'from': 111, 'to': 150, 'color': 'red'}],
              valueBox: false, ticksAngle: 225, startAngle: 67.5,
              colorMajorTicks: '#ddd', colorMinorTicks: '#ddd', colorTitle: '#eee', colorUnits: '#ccc', colorNumbers: '#eee',
              colorPlate: '#333', borderShadowWidth: 0, borders: true, needleType: 'arrow', needleWidth: 2, needleCircleSize: 7,
              needleCircleOuter: true, needleCircleInner: false, colorBorderOuter: '#333', colorBorderOuterEnd: '#444',
              colorBorderMiddle: '#222', colorBorderMiddleEnd: '#444', colorBorderInner: '#444', colorBorderInnerEnd: '#333',
              colorNeedleShadowDown: '#333', colorNeedleCircleOuter: '#333', colorNeedleCircleOuterEnd: '#444',
              colorNeedleCircleInner: '#444', colorNeedleCircleInnerEnd: '#222', valueBoxBorderRadius: 0,
              colorValueBoxRect: '#222', colorValueBoxRectEnd: '#333', animation: false
        }"></radial-gauge>
      </div>
    </div>
    <h1 style="font-family: Verdana">{{ telemetry.time | timeInHours }}</h1>
  </div>
</template>

<script>
import { RadialGauge, LinearGauge } from 'vue-canvas-gauges'
import VmProgress from 'vue-multiple-progress'

export default {
  components: {
    RadialGauge,
    LinearGauge,
    VmProgress
  },
  name: 'hello',
  data () {
    return {
      msg: 'Telemetry',
      completedSteps: 1,
      totalSteps: 10,
      telemetry: { wheelTemperature: {}, wheelWear: {} }
    }
  },
  mounted() {
    var socket = new WebSocket('ws://localhost:8080/gauge')
    socket.onopen = () => {
      console.log('WebSocket is open')
    }
    socket.onmessage = (message) => {
      this.telemetry = JSON.parse(message.data)
    }
  },
  filters: {
    timeInHours: function (value) {
      let hours = parseInt(Math.floor(value / 360))
      let minutes = parseInt(Math.floor((value - (hours * 360)) / 60))
      let seconds = parseInt((value - ((hours * 360) + (minutes * 60))) % 60)

      let dHours = (hours > 9 ? hours : '0' + hours)
      let dMins = (minutes > 9 ? minutes : '0' + minutes)
      let dSecs = (seconds > 9 ? seconds : '0' + seconds)

      return dHours + ':' + dMins + ':' + dSecs
    }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
h1, h2 {
  font-weight: normal;
}

ul {
  list-style-type: none;
  padding: 0;
}

li {
  display: inline-block;
  margin: 0 10px;
}

a {
  color: #42b983;
}
</style>
