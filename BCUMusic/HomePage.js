import React, {Component} from 'react';
import {View,TextInput,TouchableOpacity,Image,Dimensions,Text,Slider} from 'react-native';
import { createMaterialTopTabNavigator } from '@react-navigation/material-top-tabs';
import MusicPage from "./pages/MusicPage"
import CollectionPage from "./pages/CollectionPage"
import ArtistPage from "./pages/ArtistPage"
import PlayButton from "./PalyButton"
import Video from 'react-native-video'

let MainHeight = Dimensions.get('window').height;
let MainWidth = Dimensions.get('window').width;
const Tab = createMaterialTopTabNavigator();


export default class Nave extends Component {
    constructor(props) {
        super(props);
        this.state={
            paused:true,
            music:[],
            musicIndex:0,
            sliderValue:0,
            currentTime:0,
        }
    }

    _playMusic(){
        this.setState({paused:false})
    }
    _pausedMusic(){
        this.setState(({paused:true}))
    }

    customerOnprogress(e){
        let time = e.currentTime;   // 获取播放视频的秒数
        this.setState({
            currentTime: time,
            sliderValue: time
        })
    }

    componentDidMount() {
    }
    _showMusicPage=()=>{
        return(<MusicPage setMusicPlay={(data)=>this._setMusicPlay(data)}/>)
    }
    _showCollectionPage=()=>{
        return(<CollectionPage setMusicPlay={(data)=>this._setMusicPlay(data)}/>)
    }
    _showArtistPage=()=>{
        return(<ArtistPage/>)
    }

    _setMusicPlay=(music)=>{
        this.setState({music:music,paused:false})
        console.log("music")
        console.log(music)
    }



    render() {
        return (
            <View style={{flex: 1}}>
                <View style={{flexDirection: 'row',width:MainWidth-30,height:60,marginTop:15,marginBottom:15,marginRight:15,marginLeft:15,backgroundColor:"#dddddd",padding:10,paddingBottom:5,borderRadius:30,}}>
                    <Text style={{fontSize:30,color:"#2557d7",marginLeft:10}}>BCU MUSIC</Text>
                </View>
                <Tab.Navigator
                    tabBarOptions ={{
                        inactiveTintColor: '#000000',
                        activeTintColor: '#000000',
                        style:{
                            backgroundColor:'#'
                        }
                    }}
                >
                    <Tab.Screen name="推荐音乐TOP10" component={this._showMusicPage} />
                    <Tab.Screen name="专辑" component={this._showCollectionPage} />
                    {/*<Tab.Screen name="艺术家" component={this._showArtistPage} />*/}
                </Tab.Navigator>


                <View style={{height:80,width:MainWidth}}>
                    <TouchableOpacity style={{flex:1 ,flexDirection: 'row',padding:10}}>
                        <Image source={{uri:this.state.music.musicImg}} style={{height:60,width:60,backgroundColor: "#aaaaaa"}}/>
                        <View style={{marginLeft:10,width:MainWidth-170}}>
                            <Text style={{fontSize:20}}>{this.state.music.musicName}</Text>
                            <Text>{this.state.music.musicArtist} - {this.state.music.musicCollection}</Text>
                            <Slider disabled={true} value={this.state.sliderValue} maximumValue={this.state.music.musicLenth}/>
                        </View>
                        <View style={{flexDirection: 'row',alignItems:'center'}}>
                            <PlayButton style={{marginRight:10}} playMusic={()=>this._playMusic()} pausedMusic={()=>this._pausedMusic()} PP={this.state.paused}/>
                            <TouchableOpacity onPress={()=>this._test()}>
                                <Image source={require('./src/images/play_list_icon.png')} style={{height:40,width:40}}/>
                            </TouchableOpacity>
                        </View>
                    </TouchableOpacity>
                </View>
                <Video
                    source={{uri:this.state.music.localAddress}}
                    ref={(ref) => {
                        this.player = ref
                    }}
                    audioOnly={true}
                    paused={this.state.paused}
                    onProgress={(e)=>this.customerOnprogress(e)}
                />
            </View>
        )
    }
}
