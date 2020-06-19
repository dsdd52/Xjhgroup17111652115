import {FlatList, ScrollView, Text, View} from 'react-native';
import React, {Component} from 'react';
let address='http://192.144.141.198:8080/MyCloudMusic'

export default class ArtistPage extends Component {
    constructor(props) {
        super(props);
        this.state = {data: []}
    }
    componentDidMount() {
        fetch(address+"/music/collection?name="+this.props.collectionName,{method:'GET'})
            .then((response) => response.json())
            .then((responseJson) =>{
                this.setState({data:responseJson.obj})
            }).catch((error) => {
            console.log(error);})
    }
    render() {
        return (
            <View >
                <View>

                </View>
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
