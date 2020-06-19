import React, {Component} from 'react';
import {View,Text, StyleSheet,TouchableOpacity,Slider,Image } from 'react-native';

export default class ListItemBase extends Component {
    constructor(props) {
        super(props);
    }
    componentDidMount() {
    }
    render() {
        return (
            <TouchableOpacity style={itemStyles.container} onPress={()=>this.props.setMusicPlay(this.props.itemInfo)}>
                <View style={itemStyles.itemInfoViewStyle}>
                    <Image
                        style={itemStyles.infoImageStyle}
                        source={{uri:this.props.itemInfo.musicImg}}/>
                    <View style={{flex:1}}>
                        <Text style={itemStyles.infoTextStyle} ellipsizeMode={'tail'} numberOfLines={1}>{this.props.itemInfo.musicName}</Text>
                        <Text style={itemStyles.singerTextStyle}  ellipsizeMode={'tail'} numberOfLines={2}>{this.props.itemInfo.musicArtist}-{this.props.itemInfo.musicCollection}</Text>
                    </View>
                </View>
                <View style={itemStyles.ButtonViewStyle}>
                    <TouchableOpacity style={itemStyles.buttonStyle} onPress={()=>this.props.delItem()}>
                        <Image source={require('../src/images/add_music_list.png')} style={{width:30,height:30}}/>
                    </TouchableOpacity>
                </View>
            </TouchableOpacity>
        )
    }

}
let itemStyles = StyleSheet.create({
    container: {
        margin:2,
        borderRadius:5,
        flexDirection: 'row',
        height: 100,

    },
    itemInfoViewStyle:{
        flexDirection: 'row',
        flex:0.8,
    },
    ButtonViewStyle:{
        flex: 0.2,
    },
    buttonStyle:{
        borderRadius:5,
        flex:1,
        marginTop:5,
        marginBottom:5,
        marginEnd:5,
        justifyContent:'center',
        alignItems:'center',
    },
    button2Style:{
        borderBottomLeftRadius:5,
        borderBottomRightRadius:5,
        flex:1,
        marginTop:1,
        marginBottom:5,
        marginEnd:5,
        backgroundColor:'#923922',
    },
    buttonTextStyle:{
        textAlign: 'center',
        fontSize:30,
        color:'#ffffff',
    },
    infoTextStyle:{
        textAlign: 'left',
        fontSize:25,
        color:'#000000'
    },
    singerTextStyle:{
        textAlign: 'left',
        fontSize:20,
        color:'#000000'
    },
    infoImageStyle:{
        borderRadius:5,
        margin: 5,
        height: 90,
        width:90,
        resizeMode: 'contain',
    }
});
