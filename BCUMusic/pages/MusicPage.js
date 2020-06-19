
import React, {Component} from 'react';
import {View,Text, StyleSheet,TouchableOpacity,Slider,Dimensions,FlatList } from 'react-native';
import Orientation from 'react-native-orientation';
import ListItemBase from './ListItemBase';

let address='http://192.144.141.198:8080/MyCloudMusic'
export default class Home extends Component {
    constructor(props) {
        super(props);
        this.state={data:[]};
    }

    componentWillUnmount() {
    }

    componentDidMount() {
        fetch(address+"/music/top",{method:'GET'})
            .then((response) => response.json())
            .then((responseJson) =>{
                this.setState({data:responseJson.obj})
            }).catch((error) => {
            console.log(error);})
    }

    getMusicInfo=(data)=>{
        this.props.setMusicPlay(data)
    }

    _renderItem=({item,index})=>{
        return (
            <ListItemBase
                itemInfo={item}
                delItem={()=>this._delete(item)}
                setMusicPlay={(data)=>this.getMusicInfo(data)}
            />
        )
    }
    _ItemSeparatorComponent=()=>{
        return <View style={{height:1,backgroundColor:'#ffffff'}}></View>
    }

    render() {
        console.log(this.state.data)
        return (
            <View style={{flex: 1}}>
                <FlatList
                    data={this.state.data}
                    renderItem={this._renderItem}
                    keyExtractor={(item)=>item.id}
                    ListEmptyComponent={<Text>你的订单不存在</Text>}
                    ItemSeparatorComponent={this._ItemSeparatorComponent}
                />

            </View>
        )
    }
}
