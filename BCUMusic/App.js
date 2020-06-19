import React, {Component} from 'react';
import {Text, View, Image,TouchableOpacity,Dimensions,ScrollView,} from 'react-native';
import Orientation from 'react-native-orientation';

let address='http://192.144.141.198:8080/MyCloudMusic'
export default class App1 extends Component {
  constructor(props) {
    super(props);
    this.state={ad:[],timeCount:5,adImg:""};
  }

  componentWillUnmount() {
    Orientation.lockToPortrait();
  }

  UNSAFE_componentWillMount() {
    Orientation.lockToPortrait();
  }
  componentDidMount() {
      this.scrollBar();
      fetch(address+"/ad/",{method:'GET'})
          .then((response) => response.json())
          .then((responseJson) =>{
              this.setState({ad:responseJson.obj})
          }).catch((error) => {
              console.log(error);})
  }
  scrollBar=()=>{
    this.timer=setInterval(
        ()=>{
          if(this.state.timeCount>0)
            this.setState({timeCount:this.state.timeCount-1});
          else {
              clearInterval(this.timer);
              this._nextPage();
          }
        },1000
    )
  }
  _nextPage=()=>{
      this.props.setN();
      this.props.AppNavigation.navigate('Home')
  }

  render() {
    return (
      <View style={{flex:1 }}>
        <Image source={{uri:this.state.ad.adImg}} style={{flex:1}}/>
        <View style={{position: 'absolute',right:0,bottom:0}}>
          <TouchableOpacity
              onPress={this._nextPage}
              style={{
                paddingTop:5,
                paddingBottom:5,
                paddingLeft:10,
                paddingRight:10,
                borderRadius:20,
                marginBottom:30,
                marginRight:30,
                borderWidth:1.5,
                borderColor:"#00000033",
                backgroundColor:"#00000011"
          }}>
            <Text style={{width:60,textAlign: 'center',color:"#00000099"}}>
              跳过 {this.state.timeCount}秒
            </Text>
          </TouchableOpacity>
        </View>
      </View>
    );
  }
}

