<template>
    <div style="margin: -10px -15px 0 -15px;">
        <v-card-text>
            <div class="label-title"></div>
            <div v-if="editMode">
                <v-select
                    v-model="value"
                    :label="label"
                    :items="selections"
                    solo
                ></v-select>
            </div>
            <div v-else>
                ProductStatus : {{ value }}
            </div>
        </v-card-text>
    </div>
</template>

<script>
import BaseEntity from './base-ui/BaseEntity.vue';

export default {
    name: 'ProductStatus',
    mixins:[BaseEntity],
    components:{},
    props: {
        label: String
    },
    data: () => ({
        selections : [" Estimate","Development","Produce",],
    }),
    async created() {
        this.value = this.modelValue
        if(!this.value) {
            this.value = [];
        }
    },
    watch: {
        value(newVal) {
            this.$emit("update:modelValue", newVal);
        },
        
    },
    methods: {
    }
}
</script>

