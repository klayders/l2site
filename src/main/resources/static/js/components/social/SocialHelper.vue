<template>
  <v-dialog v-model="dialog" width="300">

    <template v-slot:activator="{ on }">
      <v-btn icon v-on="on">
        <v-icon>mdi-share-variant</v-icon>
      </v-btn>
    </template>

    <social-sharing url="https://localhost:9000/"
                    :title="itm.title"
                    description="Server with rate x1 , adena x10, spoil x2"
                    quote="Vue is a progressive framework for building user interfaces."
                    hashtags="interlude,lineage2"
                    twitter-user="interlude"
                    inline-template>
      <div>
        <v-card>

          <network network="facebook">
            <v-btn icon small>
              <v-icon>
                mdi-facebook-box
              </v-icon>
            </v-btn>
          </network>

          <network network="vk">
            <v-btn icon small>
              <v-icon>
                mdi-vk-box
              </v-icon>
            </v-btn>

          </network>
          <network network="whatsapp">
            <v-btn icon small>
              <v-icon>
                mdi-whatsapp
              </v-icon>
            </v-btn>
          </network>

          <network network="twitter">
            <v-btn icon small>
              <v-icon>
                mdi-twitter
              </v-icon>
            </v-btn>
          </network>

          <network network="telegram">
            <v-btn icon small>
              <v-icon>
                mdi-telegram
              </v-icon>
            </v-btn>
          </network>

          <network network="odnoklassniki">
            <v-btn icon small>
              <v-icon>
                mdi-odnoklassniki
              </v-icon>
            </v-btn>
          </network>

          <network network="reddit">
            <v-btn icon small>
              <v-icon>
                mdi-reddit
              </v-icon>
            </v-btn>
          </network>

          <network network="skype">
            <v-btn icon small>
              <v-icon>
                mdi-skype
              </v-icon>
            </v-btn>
          </network>

        </v-card>
      </div>
    </social-sharing>
  </v-dialog>
</template>

<script>

    export default {
        name: "SocialHelper",
        data() {
            return {
                dialog: false,
                itm: {title: "from pojo"},
            }
        },
    }
</script>

<style scoped>

</style>


<!--      TODO: try use v-for-->
<!--      <div v-for="social in socials"-->
<!--           :key="social.shareWith">-->
<!--        {{social.title}}-->
<!--      </div>-->


// socials: [
//     {shareWith: 'whatsapp', title: 'WhatsApp'},
//     {shareWith: 'email', title: 'Email'},
//     {shareWith: 'facebook', title: 'Facebook'},
//     {shareWith: 'googleplus', title: 'GooglePlus+'},
//     {shareWith: 'line', title: 'Line'},
//     {shareWith: 'odnoklassniki', title: 'Odnoklassniki'},
//     {shareWith: 'pinterest', title: 'Pinterest'},
//     {shareWith: 'linkedin', title: 'LinkedIn'},
//     {shareWith: 'skype', title: 'Skype'},
//     {shareWith: 'sms', title: 'SmS'},
//     {shareWith: 'telegram', title: 'Telegram'},
//     {shareWith: 'twitter', title: 'Twitter'},
//     {shareWith: 'vk', title: 'Vkontakte'},
//     {shareWith: 'weibo', title: 'Weibo'},
//     {shareWith: 'reddit', title: 'Reddit'},
// ],
