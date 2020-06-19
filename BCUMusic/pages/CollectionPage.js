import {View, ScrollView, Image, Text, FlatList,TouchableOpacity} from 'react-native';
import React, {Component} from 'react';
import CollectionItem from '../CollectionItem';
import { NavigationContainer } from '@react-navigation/native';
import { createStackNavigator } from '@react-navigation/stack';
import { NavigationActions,StackActions  } from 'react-navigation' ;
import ListItemBase from './ListItemBase';
let Stack = createStackNavigator();

let address='http://192.144.141.198:8080/MyCloudMusic'
export default class Home extends Component {
    constructor(props) {
        super(props);
        this.state={data:[],itemList:[],collectionInfo:[],musicList:[],infoView:[]}
    }

    componentDidMount() {
        fetch(address+"/collection/all",{method:'GET'})
            .then((response) => response.json())
            .then((responseJson) =>{
                this.setState({data:responseJson.obj})
                responseJson.obj.forEach(
                    this._putCollectionToList
                )
            }).catch((error) => {
            console.log(error);})
    }

    getMusicInfo(data){
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

    _showCollection=(item)=>{
        console.log("!!")
        console.log(item)
        fetch(address+"/music/collection?name=" +item.collectionName,{method:'GET'})
            .then((response) => response.json())
            .then((responseJson) =>{
                console.log(responseJson)
                this._showCollectionOverview(item,responseJson.obj)
            }).catch((error) => {
            console.log(error);})
    }

    _putCollectionToList=(item,index)=>{
        this.state.itemList.push(
                <CollectionItem collection={item} showCollection={(item)=>this._showCollection(item)}/>
            )
        this.setState({infoView:[]})
    }

    _dismiss=()=>{
        console.log("!!")
        this.setState({infoView:[]})
    }


    _showCollectionOverview=(item,musicList)=>{
        this.setState({infoView:
                <View style={{top:0,bottom:0,left:0,right:0,backgroundColor:"#efefef",position: 'absolute'}} >
                    <TouchableOpacity onPress={()=>this._dismiss()}>
                        <Image source={require('../src/images/back_icon.png')} style={{width:30,height:30}}/>
                    </TouchableOpacity>
                    <View style={{backgroundColor:'',flex:1,padding:15}}>
                        <View style={{flexDirection: 'row',marginBottom:5}}>
                            <Image
                                source={{uri:item.collectionImg}}
                                style={{height:100,width:100}}
                            />
                            <View style={{marginLeft:15}}>
                                <Text style={{fontSize:35}}>{item.collectionName}</Text>
                                <Text style={{fontSize:20}}>发行商：{item.collectionPublisher}</Text>
                                <Text style={{fontSize:20}}>语言：{item.collectionLanguage}</Text>
                            </View>
                        </View>
                        <FlatList
                            data={musicList}
                            renderItem={this._renderItem}
                            keyExtractor={(item)=>item.id}
                            ListEmptyComponent={<Text>你的订单不存在</Text>}
                            ItemSeparatorComponent={this._ItemSeparatorComponent}
                        />
                    </View>

                </View>
        })
    }


    render() {
        return (
            <View style={{flex: 1}}>
                <ScrollView>
                    <View
                        style={{flexDirection: 'row', flexWrap:"wrap",justifyContent:'space-between',padding:15}}
                        ref={(ref) => this.ItemListView = ref}
                    >
                        {this.state.itemList}
                    </View>
                </ScrollView>

                {this.state.infoView}
            </View>
        )
    }
}
