<template>
  <v-content>
    <div v-for="link in links"
         :key="link.title">
      <v-card
        class="mx-auto my-2 pa-md-4 "
        outlined
        v-ripple="{ center: true }"
        width="500"
        color="rgb(0, 0, 0, 0.2)">


        <v-card-actions>
          <v-container>
            <span>Download client from </span>
            <v-btn text :href="link.client">
              {{link.title}}
            </v-btn>
          </v-container>
          <v-container v-if="link.patch !== ''">
            <span>Download patch from </span>
            <v-btn text :href="link.patch">
              {{link.title}}
            </v-btn>
          </v-container>
        </v-card-actions>
      </v-card>
    </div>
  </v-content>
</template>

<script>
    export default {
        name: "Download",
        data() {
            return {
                links: [
                    {title: 'Yandex', client: 'https://yadi.sk/d/qqFrgaDu32XMhM', patch: 'harcode'},
                    {title: 'Rutracker', client: 'https://rutracker.org/forum/viewtopic.php?t=3923644', patch: ''},
                    {
                        title: 'Playground',
                        client: 'https://www.playground.ru/files/lineage_2_interlude_client-7689/',
                        patch: ''
                    },
                ],
            }
        }
    }
</script>

<style scoped>

</style>
