package com.eshopping.eshopping_backend.mapper;

import com.eshopping.eshopping_backend.dto.AddressDto;
import com.eshopping.eshopping_backend.model.Address;

public class AddressMapper {

    public static Address mapToAddress(AddressDto addressDto) {
            Address address = new Address();
            address.setId(addressDto.getId());
            address.setStreet(addressDto.getStreet());
            address.setCity(addressDto.getCity());
            address.setCountry(addressDto.getCountry());
            address.setStreetNumber(addressDto.getStreetNumber());
            return address;
    }

    public static AddressDto mapToAddressDto(Address address) {
            AddressDto addressDto = new AddressDto();
            addressDto.setId(address.getId());
            addressDto.setStreet(address.getStreet());
            addressDto.setCity(address.getCity());
            addressDto.setCountry(address.getCountry());
            addressDto.setStreetNumber(address.getStreetNumber());
            return addressDto;
        }
    }




