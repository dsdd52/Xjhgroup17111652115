import React, {Component} from 'react';
import {View,TextInput,TouchableOpacity,Image,Dimensions,Text} from 'react-native';

export default class Nave extends Component {
    constructor(props) {
        super(props);
        this.state={states:true}
    }

    _playMusic(){
        this.props.playMusic()
    }
    _pausedMusic(){
        this.props.pausedMusic()
    }

    render() {
        if(this.props.PP){
            return (
                <TouchableOpacity onPress={()=>this._playMusic()}>
                    <Image source={require('./src/images/play_icon.png')} style={{flex:1,height:40,width:40,resizeMode:"contain"}}/>
                </TouchableOpacity>
            )
        }else {
            return (
                <TouchableOpacity onPress={()=>this._pausedMusic()}>
                    <Image source={require('./src/images/pause_icon.png')} style={{flex:1,height:40,width:40,resizeMode:"contain"}} />
                </TouchableOpacity>
            )
        }

    }
}
